import java.awt.Cursor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Usuario
 */
public interface Delay {

    public default void delay() throws InterruptedException {
        delay(2);
    }

    public default void delay(int seconds) throws InterruptedException {
        setCursor(new Cursor(Cursor.WAIT_CURSOR));
        TimeUnit.SECONDS.sleep(seconds);
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

    }

    public void setCursor(Cursor cursor);

}
