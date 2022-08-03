package kivetelkezeles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/*
 Alkalmazzunk kivételkezelést a következõ feladatsorban. Térképezzük fel az összes hibalehetõséget,
  idézzük elõ õket, figyeljük meg, milyen kivételeket dobnak, majd kezeljük le mindegyiket,
   hogy a következõ futásnál már ne okozzanak programleállást.
1., Kérjünk be a felhasználótól három számot.
2., Hozzunk létre egy tömböt, elemszáma legyen egyenlõ a számok szorzatával.
3., Írjuk ki a tömb[elemszámadik] elemét.
4., A számok összegét osszuk el a legkisebb számmal.
5., Deklaráljunk kér String-et, az egyik hordozzon egy -a felhasználótól bekért- fájlnevet; a fájlt nyissuk is meg olvasásra.
6., Írjuk ki mindkét szöveges változó elsõ karakterét.

 */
public class Kivetelkezeles {

	public static void main(String[] args) {
		
		int elso=0;
		int masodik=0;
		int harmadik=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean jo = false;
		
		// 1. feladat:
		do {
			try {

				System.out.print("Kérem az elsõ számot: ");
				elso = Integer.parseInt(br.readLine());
				System.out.print("Kérem a második számot: ");
				masodik = Integer.parseInt(br.readLine());
				System.out.print("Kérem a harmadik számot: ");
				// br.close()	--> br korai lezárása IOException-t eredményez
				harmadik = Integer.parseInt(br.readLine());
				jo=true;
				
			} catch (NumberFormatException e) {
				System.out.println("Nem megfelelõ formátum vagy értéktartomány!");
			} catch (IOException e) {
				System.out.println("I/O hiba!");
			} 
		} while (!jo);
		
		
		// 2. feladat:
		try {
			int[] tomb = new int[elso*masodik*harmadik];
			
			// 3.feladat:
			// System.out.println(tomb[tomb.length]);
			
			// 4. feladat:
			System.out.println((elso+masodik+harmadik)/Math.min(Math.min(elso, masodik),harmadik));
		}
		catch (NegativeArraySizeException e) {
			System.err.println("Negatív elemszáma nem lehet a tömbnek!");
		}
		catch (OutOfMemoryError e) {
			System.err.println("Túl nagy elemszám");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			//System.out.println(e.getMessage());
			System.out.println("Nem létezõ index!");
		}
		catch (ArithmeticException e) {
			System.out.println("Nullával történõ osztás nem megengedett!");
		}

		// 5. feladat:
		String szoveg = null;
		String fajlnev = null;
		
		System.out.println("Adja meg a megnyitandó fájl nevét: ");
		
		
		try {
			fajlnev = br.readLine();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		}
		catch (FileNotFoundException e) {
			System.err.println("Nem létezõ fájl!");
		}
		catch (IOException e) {
			System.err.println("I/O hiba!");
		}
		
		// 6. feladat:
		try {
			System.out.println(fajlnev.charAt(0));
			System.out.println(szoveg.charAt(0));
		} catch (NullPointerException e) {
			System.err.println("Nincs értéke a Stringnek!");
		}
		
		System.out.println("Sikeres lefutás!");
	}

}
