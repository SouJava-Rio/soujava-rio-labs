package br.org.soujava.rio.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Router;

public class Main extends AbstractVerticle {

    public static void main(String[] args) {

        var vertx = Vertx.vertx();
        vertx.deployVerticle(new Main());

        var router = Router.router(vertx);

        router.get("/api/jug").handler(routingContext -> {
            routingContext.response()
                          .putHeader("content-type", "application/json; charset=utf-8")
                          .end(Json.encodePrettily(new JUG()));
        });

        vertx.createHttpServer().requestHandler(router).listen(8080, res -> {
            if (res.succeeded()) {
                System.out.println("Server is now listening! " + System.currentTimeMillis());
            } else {
                System.out.println("Failed to bind!");
            }
        });

    }

}
