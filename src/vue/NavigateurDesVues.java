package vue;

import javafx.application.Application;
import javafx.stage.Stage;

public class NavigateurDesVues extends Application {
	
	private VuePokemon vuePokemon;
	private VueListePokemon vueListePokemon;
	private VueAjouterPokemon vueAjouterPokemon;
	
	public NavigateurDesVues() 
	{
		this.vuePokemon = new VuePokemon();
		this.vueListePokemon = new VueListePokemon();
		this.vueAjouterPokemon = new VueAjouterPokemon();
	}

	@Override
	public void start(Stage stade) throws Exception {
		stade.setScene(this.vueListePokemon);
		stade.show();
	}

}
