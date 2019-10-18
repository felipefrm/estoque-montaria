package tp1;
import java.util.ArrayList;
import java.util.Scanner;

public interface MontariaInterface {
	public Montaria criaMontaria(Scanner sc);
	public void menu(ArrayList<Montaria> montarias);
	public boolean removeMontaria(ArrayList<Montaria> montarias);
}
