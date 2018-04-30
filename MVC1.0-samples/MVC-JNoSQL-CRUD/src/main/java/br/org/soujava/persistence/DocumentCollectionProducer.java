package br.org.soujava.persistence;

import org.jnosql.diana.api.Settings;
import org.jnosql.diana.api.document.DocumentCollectionManager;
import org.jnosql.diana.api.document.DocumentCollectionManagerFactory;
import org.jnosql.diana.api.document.DocumentConfiguration;
import org.jnosql.diana.mongodb.document.MongoDBDocumentConfiguration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class DocumentCollectionProducer {


    private static final String DOCUMENT_COLLECTION = "people";

    @Produces
    @ApplicationScoped
    public DocumentCollectionManager getDocumentCollectionManager() {
        DocumentConfiguration<?> configuration = new MongoDBDocumentConfiguration();
        Settings settings = Settings.builder().put("mongodb-server-host-1", "localhost:27017").build();
        DocumentCollectionManagerFactory managerFactory = configuration.get(settings);
        return managerFactory.get(DOCUMENT_COLLECTION);
    }
}
