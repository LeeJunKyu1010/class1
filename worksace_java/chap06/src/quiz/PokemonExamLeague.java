package quiz;

import java.util.ArrayList;

public class PokemonExamLeague {

	String name = "";
//	String name = null; null도 상관 없음
	ArrayList list = new ArrayList();
	Pokemon[] arrPokemon = new Pokemon[10];

	
	PokemonExamLeague(String name){
		System.out.println("name :" + name );
		this.name = name;
	}
	
	
	void add(Pokemon p) {
		this.list.add(p);
	}

	
	void print() {
		System.out.println("--------------");
		System.out.println(this.name + "리그참가 포켓몬 목록입니다.");
		System.out.println();
		for(int i=0; i<list.size(); i++) {
			Pokemon p = (Pokemon)list.get(i);
			System.out.println("이름"+p.name);
			System.out.println("타입"+p.type);
			System.out.println();
		}
	}
	
	Pokemon[] getArray() {
		return arrPokemon;
	}
	
}
