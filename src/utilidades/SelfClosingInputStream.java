/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.IOException;
import java.io.InputStream;
/**
 *
 * @author Manolo
 */

public class SelfClosingInputStream extends InputStream {

    private InputStream inputStream;

    public SelfClosingInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read()  throws IOException {
        int val = -1;
        try {
           val = this.inputStream.read();
            if (val != -1) {
                return val;
            } else {
                this.inputStream.close();
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Something is wrong!");
        }
        return val;
    }
}