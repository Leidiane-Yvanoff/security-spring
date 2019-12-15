package com.wildcodeschool;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping("/")
    public String hello() {
        return "Welcome to the SHIELD";
    }
	
	@GetMapping("/avengers/assemble")
	public String avengers() {
	    return "Avengers... Assemble";
	}
	
	@GetMapping("/secret-bases")
	public String admin() {
	    return "Amsterdam, Barcelone, Berlin, Biarritz, "
	    		+ "Bordeaux, Bruxelles, Bucarest, Budapest, Dublin, La Loupe, Lille, Lisbonne, "
	    		+ "Londres, Lyon, Madrid, Marseille, Milan, Nantes, Orléans, Paris, Reims, Strasbourg"
	    		+ "Toulouse, Tours";
	}
	
}
