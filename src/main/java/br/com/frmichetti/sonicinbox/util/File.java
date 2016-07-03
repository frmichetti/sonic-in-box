/**
 *
 * @author Felipe Rodrigues Michetti
 * @see http://portfolio-frmichetti.rhcloud.com
 * @see mailto:frmichetti@gmail.com
 * */
package br.com.frmichetti.sonicinbox.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;


public abstract class File {

    static java.io.File f;

    public static java.io.File[] getFiles(Path caminho) {
        f = caminho.toFile();
        if (f.exists() && f.isDirectory() && f.canRead()) {
            return f.listFiles();
        }

        return null;
    }

    public static java.io.File[] getFiles(String caminho) {

        f = new java.io.File(caminho);

        if (f.exists() && f.isDirectory() && f.canRead()) {
            return f.listFiles();
        }

        return null;

    }

    public static java.io.File[] getFiles(URL caminho) throws URISyntaxException {
        f = new java.io.File(caminho.toURI());

        if (f.exists() && f.isDirectory() && f.canRead()) {
            return f.listFiles();
        }

        return null;
    }

    public static java.io.File[] getFiles(URI caminho) {
        f = new java.io.File(caminho);
        if (f.exists() && f.isDirectory() && f.canRead()) {
            return f.listFiles();
        }

        return null;
    }

}
