# configure the Oracle infrastructure classic
provider "opc" {
  user              = "SEU E-MAIL DA CONTA ORACLE CLOUD"
  password          = "SEU PASSWORD DA CONTA ORACLE CLOUD"
  identity_domain   = "ID DO ORACLE IDENTiTY DOMAIN"
  storage_endpoint = "https://SEUIDENTITYDOMAIN.SUAREGION.storage.oraclecloud.com"
  storage_service_id = "NOME IDENTITY DOMANIN USADO PARA ENTRA NA ORACLE CLOUD"
}

#Configure the Oracle Cloud Platform provider
provider "oraclepaas" {
  user              = "SEU E-MAIL DA CONTA ORACLE CLOUD"
  password          = "SEU PASSWORD DA CONTA ORACLE CLOUD"
  identity_domain   = "ID DO ORACLE IDENTiTY DOMAIN"
  application_endpoint = "https://apaas.us.oraclecloud.com"
}

# Passo para criar um Storage Container

# cria um container
resource "opc_storage_container" "my-apps" {
  name = "my-apps"
}

# cria um objeto dentro do container 
# aqui ele copia o helidon-sample.zip e armazena no container chamado my-apps
resource "opc_storage_object" "helidon-java-app" {
  name         = "helidon-sample.zip"
  container    = "${opc_storage_container.my-apps.name}"
  file         = "helidon-sample.zip"
  etag         = "${md5(file("helidon-sample.zip"))}"
  content_type = "application/zip;charset=UTF-8"
}

# Passo para criar um Application Container
resource "oraclepaas_application_container" "helidon-java-app" {
  name              = "EventApp" # nome do app
  runtime           = "java" 
  archive_url       = "${opc_storage_container.my-apps.name}/${opc_storage_object.helidon-java-app.name}" #localizaçaõ do objeto do Storage
  subscription_type = "HOURLY"

  deployment {
    memory    = "1G"
    instances = 1
  }
}

output "web_url" {
  value = "${oraclepaas_application_container.helidon-java-app.web_url}/event"
}
