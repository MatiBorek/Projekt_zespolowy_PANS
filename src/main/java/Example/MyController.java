package Example;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Tuple;


@Controller
public class MyController {

    @Autowired
    OperacjaRepository operacjaRepository;

    
    @RequestMapping("/add_person")
    public String addOperacja(Model model)
    {       
        TransData transData = new TransData();                
        model.addAttribute("transData", transData);         
        return "addform";  
    }
    
    @RequestMapping(value = "/add_person", method = RequestMethod.POST)
    public String addOperacja(Model model,TransData transData)
    {
        String walutaIN = "";
        String walutaOUT = "";
        String kurs = transData.getOperator();
        String tryb = transData.getWymiana();
        if(tryb.equals("Tak")){
            walutaIN = kurs;
            walutaOUT = "PLN";
        }
        else {
            walutaIN = "PLN";
            walutaOUT = kurs;
        }
        String sValueIN = transData.getValueIN();
        double valueIN = Double.parseDouble(sValueIN);
        double valueOUT = valueIN * 5;
        double prowizja = valueOUT*0.02;
                
        operacjaRepository.save(new Operacja(walutaIN, valueIN, walutaOUT, valueOUT, prowizja));
        
        model.addAttribute("header", "Wynik"); 
        model.addAttribute("message","Wstawiono do bazy wymiane: "+walutaIN+" na "+walutaOUT);
        return "viewmessage";                
    }

    //-------------------------------------------------------------------
        
    @RequestMapping(value = "/print_all", method = RequestMethod.GET)
    public String printAll(Model model)
    {
        List<Operacja> operacjaList =  operacjaRepository.findAll();
                        
        model.addAttribute("header","Lista wszystkich operacji"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("operacjaList",operacjaList); //Dodanie obiektu do pamieci lokalnej modelu
        
        return "printform"; //Przekierowanie na strone 

    }

    @RequestMapping(value = "/print_lower", method = RequestMethod.GET)
    public String printLower(Model model)
    {
        List<Operacja> operacjaList =  operacjaRepository.findByValueINGreaterThanEqual(18.0);
                        
        model.addAttribute("header","Lista osob doroslych"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("operacjaList",operacjaList); //Dodanie obiektu do pamieci lokalnej modelu
        
        return "printform"; //Przekierowanie na strone 

    }

    @RequestMapping(value = "/print_between", method = RequestMethod.GET)
    public String printBetween(Model model)
    {
        List<Operacja> operacjaList =  operacjaRepository.findByValueINGreaterThanAndValueINLessThan(18.0, 34.00);

        model.addAttribute("header","Lista osob doroslych"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("operacjaList",operacjaList); //Dodanie obiektu do pamieci lokalnej modelu

        return "printform"; //Przekierowanie na strone

    }

    @RequestMapping(value = "/print_profit", method = RequestMethod.GET)
    public String printProfit(Model model)
    {
        List<Tuple> operacjaList =  operacjaRepository.SumProwizja();
        model.addAttribute("header","Lista prowizji sumarycznych"); //Dodanie obiektu do pamieci lokalnej modelu
        model.addAttribute("operacjaList",operacjaList); //Dodanie obiektu do pamieci lokalnej modelu

        return "printformProwizja"; //Przekierowanie na strone

    }

    //-------------------------------------------------------------------    
    
    //Obsluga bledow

    @ExceptionHandler
    public String handlerException(Model model,Exception exception)
    {
        String message = exception.getMessage();
        model.addAttribute("errormessage", message);
        return "errorpage";
    }
}

        