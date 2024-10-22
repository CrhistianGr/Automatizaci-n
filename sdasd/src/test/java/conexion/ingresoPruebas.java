package conexion;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Test;

public class ingresoPruebas {
    private WebDriver driver;

    public ingresoPruebas(WebDriver driver) {
        this.driver = driver;
    }

    public void iniciarSesion() {
        driver.get("http://10.250.3.66:8080/savia/login.faces");
        driver.manage().window().setSize(new Dimension(1700, 900));
        esperar(500);
        driver.findElement(By.cssSelector("input#login\\:usuario")).sendKeys("csepulvg");
        esperar(500);
        driver.findElement(By.cssSelector("input#login\\:contrasena")).sendKeys("kBXSFADe");
        esperar(500);
        driver.findElement(By.cssSelector("button[name='login:j_idt23']")).click();
        esperar(2000);
    }

    private void esperar(long tiempo) {
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
