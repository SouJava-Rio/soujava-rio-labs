package pippo.demo;

import ro.pippo.core.Pippo;

public class AppMain {
    public static void main(String[] args) {
        var pippo = new Pippo(new MyApplication());
        pippo
        .setFilterPath("/api/*")
        .start();
    }
}
