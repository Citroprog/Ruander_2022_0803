package kivetelkezeles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/*
 Alkalmazzunk kiv�telkezel�st a k�vetkez� feladatsorban. T�rk�pezz�k fel az �sszes hibalehet�s�get,
  id�zz�k el� �ket, figyelj�k meg, milyen kiv�teleket dobnak, majd kezelj�k le mindegyiket,
   hogy a k�vetkez� fut�sn�l m�r ne okozzanak programle�ll�st.
1., K�rj�nk be a felhaszn�l�t�l h�rom sz�mot.
2., Hozzunk l�tre egy t�mb�t, elemsz�ma legyen egyenl� a sz�mok szorzat�val.
3., �rjuk ki a t�mb[elemsz�madik] elem�t.
4., A sz�mok �sszeg�t osszuk el a legkisebb sz�mmal.
5., Deklar�ljunk k�r String-et, az egyik hordozzon egy -a felhaszn�l�t�l bek�rt- f�jlnevet; a f�jlt nyissuk is meg olvas�sra.
6., �rjuk ki mindk�t sz�veges v�ltoz� els� karakter�t.

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

				System.out.print("K�rem az els� sz�mot: ");
				elso = Integer.parseInt(br.readLine());
				System.out.print("K�rem a m�sodik sz�mot: ");
				masodik = Integer.parseInt(br.readLine());
				System.out.print("K�rem a harmadik sz�mot: ");
				// br.close()	--> br korai lez�r�sa IOException-t eredm�nyez
				harmadik = Integer.parseInt(br.readLine());
				jo=true;
				
			} catch (NumberFormatException e) {
				System.out.println("Nem megfelel� form�tum vagy �rt�ktartom�ny!");
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
			System.err.println("Negat�v elemsz�ma nem lehet a t�mbnek!");
		}
		catch (OutOfMemoryError e) {
			System.err.println("T�l nagy elemsz�m");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			//System.out.println(e.getMessage());
			System.out.println("Nem l�tez� index!");
		}
		catch (ArithmeticException e) {
			System.out.println("Null�val t�rt�n� oszt�s nem megengedett!");
		}

		// 5. feladat:
		String szoveg = null;
		String fajlnev = null;
		
		System.out.println("Adja meg a megnyitand� f�jl nev�t: ");
		
		
		try {
			fajlnev = br.readLine();
			BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		}
		catch (FileNotFoundException e) {
			System.err.println("Nem l�tez� f�jl!");
		}
		catch (IOException e) {
			System.err.println("I/O hiba!");
		}
		
		// 6. feladat:
		try {
			System.out.println(fajlnev.charAt(0));
			System.out.println(szoveg.charAt(0));
		} catch (NullPointerException e) {
			System.err.println("Nincs �rt�ke a Stringnek!");
		}
		
		System.out.println("Sikeres lefut�s!");
	}

}
