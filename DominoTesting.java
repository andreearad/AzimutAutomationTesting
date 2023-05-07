package stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;

import static java.lang.System.out;
import static java.lang.Thread.sleep;

public class DominoTesting {
        private WebDriver driver;


    @Given("deschide site-ul Domino")
    public void deschide_site_ul_Domino() throws InterruptedException {
            WebDriverInitialize.startBrowser("https://www.domino.ro/");
        sleep(2000);
    }

    @And("aceepta cookies si acceseaza autentificarea")
    public void aceepta_cookies_si_acceseaza_autentificarea() throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@aria-label='dismiss cookie" +
                " message']")).click();
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@src='/images/specific/user1.svg']")).click();
    }

    @Then("introduce email {string}")
    public void introduce_email(String em) {
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@id='Email']")).sendKeys(em);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Continua')]")).click();
    }

    @Then("introduce parola {string}")
    public void introduce_parola(String ps) {
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@id='Password']")).sendKeys(ps);
        WebDriverInitialize.getDriver().findElement(By.xpath("//button[contains(text(),'Autentificare')]")).click();
    }


// ------------ SCENARIUL I ----------------

    @Given("cauta apartamente")
    public void cauta_apartamente() throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='level1']")).click();
        sleep(500);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='glyphicon glyphicon-search']")).click();
    }

    @Then("categorie filtrare {string}")
    public void categorie_filtrare(String lc) throws InterruptedException {
        for (WebElement i : WebDriverInitialize.getDriver().findElements(By.xpath("//*[contains(@class," +
                "'ParentTitle')]/div"))){
            if (i.getText().toLowerCase().equalsIgnoreCase(lc)){
                i.click();
            }
        }
    }

    @Then("selectie filtru {string}")
    public void selectie_filtru(String lct) throws InterruptedException {
        for (WebElement i : WebDriverInitialize.getDriver().findElements(By.xpath("//*[contains(@class," +
                "'FilterToogle')]"))){
            if (i.getText().toLowerCase().equalsIgnoreCase(lct)){
                i.click();
            }
        }
    }

    @Then("filtreaza dupa {string}")
    public void filtreaza_dupa(String clj) throws InterruptedException {
        for (WebElement i : WebDriverInitialize.getDriver().findElements(By.xpath("//*[contains(@class," +
                "'atributes-row')]/div"))){
            if (i.getText().toLowerCase().equalsIgnoreCase(clj)){
                i.findElement(By.xpath("./../div")).click();
            }
        }
    }

    @Then("show result")
    public void show_result() throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='btn btn-black fix-bottom" +
                " btn-hide']")).click();
        sleep(1000);
        String url = WebDriverInitialize.getDriver().getCurrentUrl();
        out.println(url);
    }

// ------------ SCENARIUL II ----------------

    @Given("salveaza cautarea")
    public void salveaza_cautarea() throws InterruptedException {
        WebDriverInitialize.getDriver().get("https://www.domino.ro/cautare-detaliata/productcategory/apartamente" +
                "-vanzari/ultrafilter1/242-596/119-347/68-1106/159-1257");
        sleep(2000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Salveaza Cautarea')]")).click();
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.id("requestnote")).sendKeys("Ma intereseaza " +
                "aceste criterii de cautare.");
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Cauta in continuare')]")).click();
        sleep(500);
    }

    @Given("selecteaza apartamentul")
    public void selecteaza_apartamentul() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,150)", "");
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile" +
                "/500x500/3-camere-mobilat-utilat-parcare-25750-25750.jpg?v=638131040738246261']")).click();
        sleep(1000);
    }

    @Given("afiseaza detalii")
    public void afiseaza_detalii() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,150)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Detalii compartimentare')]")).click();
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Detalii suprafete')]")).click();
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,400)", "");
        sleep(1000);
        js.executeScript("window.scrollTo(0, 10)", "");
        js.executeScript("window.scrollBy(0,100)", "");
    }

    @Then("alege alt apartament")
    public void alege_alt_apartament() throws InterruptedException {
        WebDriverInitialize.getDriver(). navigate(). back();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,450)", "");
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile" +
                "/500x500/2-camere-mobilat-utilat-parcare-25749-25749.jpg?v=638131028183913145']")).click();
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.id("xzoom-fancy")).click();
        sleep(1200);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@title='Close']")).click();
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,150)", "");
        sleep(500);
        WebDriverInitialize.getDriver(). navigate(). back();
    }

    @Then("ia legatura si proprietarul si raporteaza pret gresit")
    public void ia_legatura_si_proprietarul_si_raporteaza_pret_gresit() throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile" +
                "/500x500/3-camere-mobilat-utilat-parcare-23801-23801.jpg?v=638030060490990543']")).click();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,120)", "");
        sleep(600);
        WebDriverInitialize.getDriver().findElement(By.id("xzoom-fancy")).click();
        sleep(600);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(600);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@title='Close']")).click();
        sleep(1000);
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,150)", "");
        sleep(500);
        WebDriverInitialize.getDriver().findElement(By.id("TelefonProprietar")).click();
        sleep(1200);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Pret Gresit')]")).click();
        sleep(1200);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@id='AlertWrongPrice']/button[2]")).click();
        sleep(1200);
        WebDriverInitialize.getDriver(). navigate(). back();
        sleep(1200);
    }

    @Then("raporteaza vandut si ascunde")
    public void raporteaza_vandut_si_ascunde() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,200)", "");
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@id='DivArroundFrontProductCategory" +
                "Controller']/div[14]/div[1]")).click();
        js.executeScript("window.scrollBy(0,120)", "");
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Vandut')]")).click();
        sleep(1200);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Anuleaza')]")).click();
        sleep(1200);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Ascunde')]")).click();
        sleep(1200);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(1200);
        WebDriverInitialize.getDriver().findElement(By.id("hiddensnote")).sendKeys("Stiu ca este vandut.");
        sleep(600);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Inchide')]")).click();
        sleep(500);
        WebDriverInitialize.getDriver(). navigate(). back();
    }

    @Then("sorteaza crescator anunturile")
    public void sorteaza_crescator_anunturile() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,-6000)", "");
        WebDriverInitialize.getDriver().findElement(By.id("SortBy2")).click();
        sleep(800);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Pret Crescator')]")).click();
        sleep(800);
    }

    @Then("alege si adauga la favorite")
    public void alege_si_adauga_la_favorite() throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile" +
                "/500x500/2-camere-mobilat-utilat-parcare-20239-20239.jpg?v=637895235739348699']")).click();
        sleep(600);
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,120)", "");
        sleep(500);
        WebDriverInitialize.getDriver().findElement(By.id("xzoom-fancy")).click();
        sleep(600);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(600);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@title='Close']")).click();
        sleep(500);
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Favorit')]")).click();
        sleep(1000);
        js.executeScript("window.scrollBy(0,200)", "");
        WebDriverInitialize.getDriver().findElement(By.id("favoritesnote")).sendKeys("Doresc sa fac o oferta!");
        sleep(1000);
        js.executeScript("window.scrollBy(0,90)", "");
        sleep(500);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Adauga nota')]")).click();
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Inchide')]")).click();
        sleep(1000);
    }


// ------------ SCENARIUL III ----------------

    @Given("acceseaza contul meu")
    public void acceseaza_contul_meu() throws InterruptedException {
        sleep(1000);

    }
    @And("sterge anunturile ascunse")
    public void sterge_anunturile_ascunse() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,200)", "");
        WebDriverInitialize.getDriver().findElement(By.id("Hiddens")).click();
        js.executeScript("window.scrollBy(0,200)", "");
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Sterge')]")).click();
        sleep(1000);
        WebDriverInitialize.getDriver().switchTo().alert().accept();
        out.println("Waiting for 1 sec..");
        sleep(1_000);
    }

    @Then("sterge cautarea")
    public void sterge_cautarea() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,200)", "");
        WebDriverInitialize.getDriver().findElement(By.id("Requests")).click();
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@class='glyphicon glyphicon-remove']")).click();
        sleep(1000);
        WebDriverInitialize.getDriver().switchTo().alert().accept();
        sleep(1000);
        WebDriverInitialize.getDriver(). navigate(). back();
    }

    @Then("ia legatura cu vanzatorul si raporteaza vandut")
    public void ia_legatura_cu_vanzatorul_si_raporteaza_vandut() throws InterruptedException {
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Oferte salvate')]")).click();
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile" +
                "/500x500/2-camere-mobilat-utilat-parcare-20239-20239.jpg?v=637895235739348699']")).click();
        JavascriptExecutor js = (JavascriptExecutor) WebDriverInitialize.getDriver();
        js.executeScript("window.scrollBy(0,120)", "");
        sleep(600);
        WebDriverInitialize.getDriver().findElement(By.id("TelefonProprietar")).click();
        sleep(1000);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Vandut')]")).click();
        sleep(1200);
        WebDriverInitialize.getDriver().findElement(By.xpath("//*[contains(text(),'Anuleaza')]")).click();
        sleep(1200);
    }

}
