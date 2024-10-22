import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import conexion.ingresoPruebas;
import conexion.Conexion_BD;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;

public class anticipoPrueba {
    private WebDriver driver;
    private ingresoPruebas ingreso;
    private Connection conexion;

    @BeforeEach
    public void setUp() {
        // Configuración del WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\csepulvg\\IdeaProjects\\sdasd\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        ingreso = new ingresoPruebas(driver);  // Inicialización de la clase 'Ingreso'

        // Configuración de la conexión a la base de datos
        configurarConexionBD();
    }


    // Metodo para configurar la conexión a la BD
   private void configurarConexionBD() {
        // Crear una instancia de la clase Conexion_BD y obtener la conexión
        Conexion_BD conexionBD = new Conexion_BD();
        conexion = conexionBD.conectar();

        // Validar si la conexión a la base de datos se estableció correctamente
        if (conexion != null) {
            System.out.println("Conexión a la base de datos establecida correctamente.");
        } else {
            System.err.println("Error al establecer la conexión a la base de datos.");
        }
    }



    // Metodo para esperar la ejecución (simular delay)
    private void esperar(int milisegundos) throws InterruptedException {
        Thread.sleep(milisegundos);
    }
    @Test
    public void PrimeraAutomatizacion() throws InterruptedException {
        // Paso 1: Ingresar al sistema.
        ingreso.iniciarSesion();
        esperar(300);

        // Paso 2: Ingreso al modulo Anticipos.
        anticipos();
        esperar(300);
    }

    private void anticipos() throws InterruptedException{
        driver.get("http://10.250.3.66:8080/savia/anticipo/anticipos.faces");
        esperar(500);
        //Entra a anticipos.
        driver.findElement(By.id("frmAnticipos:j_idt48")).click();
        esperar(4000);
        //Entra a boton crear.
    }
}
