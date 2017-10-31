package com.ibanfr.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
@SessionScoped
public class BeersBean implements Serializable {
	
	final static Logger logger = LoggerFactory.getLogger(BeersBean.class);

    private Beer selectedBeer;
    private List<Beer> beers;
    
    private String name;

    public BeersBean(){
        beers = new ArrayList<Beer>();
        beers.add(new Beer(10, "La Chouffe"));
        beers.add(new Beer(20, "Stella Artois"));
        beers.add(new Beer(30, "Westmalle Trippel"));
    }
    
    @PostConstruct
    public void postConstruct(){
    	logger.debug("init postConstruct BeersBean");
//    	setSelectedBeer(beers.get(2));
    	setSelectedBeer(new Beer(20, "Stella Artois"));
    }

    public Beer getSelectedBeer() {
        return selectedBeer;
    }

    public void setSelectedBeer(Beer selectedBeer) {
        this.selectedBeer = selectedBeer;
    }

    public List<Beer> getBeers() {
        return beers;
    }

    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }

    public Beer getBeer(Integer id) {
        if (id == null){
            throw new IllegalArgumentException("no id provided");
        }
        for (Beer beer : beers){
            if (id.equals(beer.getId())){
                return beer;
            }
        }
        return null;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	public void newName(){
		setName(new String());
	}
}
