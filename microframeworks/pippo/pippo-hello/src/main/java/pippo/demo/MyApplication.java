package pippo.demo;

import ro.pippo.core.Application;

public class MyApplication extends Application {

    @Override
    protected void onInit() {
        GET("/hello", routeContext -> routeContext.json().send(new Mensagem("Hello World", 2019)));
    }
}