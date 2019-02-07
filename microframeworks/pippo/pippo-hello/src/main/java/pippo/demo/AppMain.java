package pippo.demo;

import java.util.Optional;

import ro.pippo.core.Pippo;

public class AppMain {
    public static void main(String[] args) {
        
        Optional<String> port = Optional.ofNullable(System.getenv("PORT")); 
        var pippo = new Pippo(new MyApplication());
        pippo
        .setFilterPath("/api/*")
        .start(Integer.parseInt(port.orElse("8080")));
    }
}
