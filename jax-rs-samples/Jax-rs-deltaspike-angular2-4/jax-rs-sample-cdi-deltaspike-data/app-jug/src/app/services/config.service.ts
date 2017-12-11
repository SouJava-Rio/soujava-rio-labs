export class ConfigService {

     private urlService: string;

     constructor() {

         this.urlService = 'http://localhost:8083/jax-rs-sample-cdi-deltaspike-data/app/jug/';
     }

     getUrlService(): string {

         return this.urlService;
     }

 }
