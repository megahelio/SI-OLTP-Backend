package es.uvigo.mei.drugs_to_avoid;

import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.DrugDao;
import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.ManufacturerDao;
import es.uvigo.mei.drugs_to_avoid.repository.daos_drug.PublicationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DrugsSpringApplication {

	@Autowired
	private DrugDao drugDao;
	@Autowired
	private ManufacturerDao manufacturerDao;

	@Autowired
	private PublicationDao publicationDao;

	public static void main(String[] args) {
		SpringApplication.run(DrugsSpringApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		Atc atc1 = new Atc();
//		atc1.setGrupoAnatomicoPrincipal("A01");
//		atc1.setSubgrupoTerapeutico("AB");
//		atc1.setSubgrupoFarmacologico("01");
//		atc1.setSubgrupoQuimico("A");
//		atc1.setPrincipioActivo("Paracetamol");
//		atc1.setGrupoAnatomicoPrincipalDescripcion("Aparato digestivo");
//		atc1.setSubgrupoTerapeuticoDescripcion("Antiácidos");
//		atc1.setSubgrupoFarmacologicoDescripcion("Sales");
//		atc1.setSubgrupoQuimicoDescripcion("Combinaciones");
//		atc1.setPrincipioActivoDescripcion("Alivio del dolor");
//
//		Atc atc2 = new Atc();
//		atc2.setGrupoAnatomicoPrincipal("B01");
//		atc2.setSubgrupoTerapeutico("AC");
//		atc2.setSubgrupoFarmacologico("06");
//		atc2.setSubgrupoQuimico("B");
//		atc2.setPrincipioActivo("Aspirina");
//		atc2.setGrupoAnatomicoPrincipalDescripcion("Sistema circulatorio");
//		atc2.setSubgrupoTerapeuticoDescripcion("Anticoagulantes");
//		atc2.setSubgrupoFarmacologicoDescripcion("Ácido acetilsalicílico");
//		atc2.setSubgrupoQuimicoDescripcion("Combinaciones");
//		atc2.setPrincipioActivoDescripcion("Prevención de coágulos");
//
//		Address address1 = new Address();
//		address1.setNumber(123);
//		address1.setFloor(4);
//		address1.setLetra("B");
//		address1.setRoad("Calle Mayor");
//		address1.setCity("Madrid");
//		address1.setCountry("España");
//		address1.setRegion("Comunidad de Madrid");
//
//		Address address2 = new Address();
//		address2.setNumber(456);
//		address2.setFloor(2);
//		address2.setLetra("A");
//		address2.setRoad("Avenida Central");
//		address2.setCity("Barcelona");
//		address2.setCountry("España");
//		address2.setRegion("Cataluña");
//
//		Manufacturer manufacturer1 = new Manufacturer();
//		manufacturer1.setName("PharmaCorp");
//		manufacturer1.setCif("A12345678");
//		manufacturer1.setAddress(address1);
//
//		Manufacturer manufacturer2 = new Manufacturer();
//		manufacturer2.setName("MediHealth");
//		manufacturer2.setCif("B87654321");
//		manufacturer2.setAddress(address2);
//
//		manufacturerDao.save(manufacturer1);
//		manufacturerDao.save(manufacturer2);
//
//		Product product1 = new Product();
//		product1.setGtin(100000000001L);
//		product1.setName("Paracetamol 500mg");
//		product1.setUnits(20);
//		product1.setMgs(500);
//		product1.setManufacturer(manufacturer1);
//
//		Product product2 = new Product();
//		product2.setGtin(100000000002L);
//		product2.setName("Aspirina 100mg");
//		product2.setUnits(30);
//		product2.setMgs(100);
//		product2.setManufacturer(manufacturer2);
//
//		HealthAlert alert1 = new HealthAlert();
//		alert1.setIdHealthAlert(1L);
//		alert1.setAlertLink("https://example.com/alert1");
//		alert1.setOrganization("FDA");
//
//		HealthAlert alert2 = new HealthAlert();
//		alert2.setIdHealthAlert(2L);
//		alert2.setAlertLink("https://example.com/alert2");
//		alert2.setOrganization("EMA");
//
//		Drug drug1 = new Drug();
//		drug1.setAtc(atc1);
//		drug1.setReasonToAvoid("Alto riesgo de daño hepático.");
//		drug1.setAlternative("Ibuprofeno");
//		drug1.setIsPrimaryCare(true);
//		drug1.setHealthAlertList(List.of(alert1));
//		drug1.setProductList(List.of(product1));
//
//		Drug drug2 = new Drug();
//		drug2.setAtc(atc2);
//		drug2.setReasonToAvoid("Riesgo de sangrado excesivo.");
//		drug2.setAlternative("Clopidogrel");
//		drug2.setIsPrimaryCare(false);
//		drug2.setHealthAlertList(List.of(alert2));
//		drug2.setProductList(List.of(product2));
//
//		drugDao.save(drug1);
//		drugDao.save(drug2);
//
//		Publication publication1 = new Publication();
//		publication1.setYear(2022);
//		publication1.setPublicationLink("https://prescrire.org/publication2022");
//		publication1.setDrugList(List.of(drug1, drug2));
//
//		Publication publication2 = new Publication();
//		publication2.setYear(2023);
//		publication2.setPublicationLink("https://prescrire.org/publication2023");
//		publication2.setDrugList(List.of(drug1));
//
//		publicationDao.save(publication1);
//		publicationDao.save(publication2);
//	}
}
