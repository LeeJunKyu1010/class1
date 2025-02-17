package sec02.exam01;

public class DriverExam {

	public static void main(String[] args) {

		Coupe c = new Coupe();
		
		Driver d = new Driver();
		d.run(c);
		
		Landrover L = new Landrover();
		d.run(L);
		
//		HumanCar humanCar = new HumanCar();
//		d.run(humanCar);
		
		Car c1 = new Car();
		Landrover land = (Landrover)c1;
	}

}
