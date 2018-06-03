export class ConfigService {

     private urlService: string;
     private ur: string;

     constructor() {

         this.urlService = 'http://localhost:8080/api/';
     }

     getUrlService(): string {

         return this.urlService;
     }
 }
