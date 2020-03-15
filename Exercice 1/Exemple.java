package fr.u_picardie.active.c306;

/**
 * Ma class d'exemple.
 */
public class Exemple {
/**
* Propriété t de la classe Exemple.
*/
 private final String t;
 /**
* Propriété v de la classe Exemple.
*/
 private final int v;
 /**
* Constructeur avec parametre.
* @param t de type chaine de caractere
*/
public Exemple(final String tParam) {
t = tParam;
}
/**
* @return la valeur de v
*/
public int getV() {
return this.v;
}
public final void setV(final int vParam) { this.v = vParam;
}
/**
* @return t si v est positif
*/
public final String getT() {
if ( v > 0) { return t; }
}
}
