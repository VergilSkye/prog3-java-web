package br.com.prog3.tra6.view;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import br.com.prog3.tra6.view.Theme;
import br.com.prog3.tra6.view.ThemeService;

@ManagedBean
public class ThemeSwitcherView {
	private List<Theme> themes;	
	
	
    @ManagedProperty("#{themeService}")
    private ThemeService service; 
    
    @PostConstruct
    public void init() {
        themes = service.getThemes();
    }
 
    public List<Theme> getThemes() {
        return themes;
    }
 
    public void setService(ThemeService service) {
        this.service = service;
    }	

}
