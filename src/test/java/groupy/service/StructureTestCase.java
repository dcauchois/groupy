package groupy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import groupy.entity.Structure;
import groupy.exception.EntityExistsException;
import groupy.exception.EntityNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class StructureTestCase {

	@Autowired
	private StructureService structureService;

	private static ArrayList<Structure> structures;
	private static String libelle;

	@BeforeClass
	public static void init(){
		structures = new ArrayList<Structure>();
		libelle = "structure"+System.currentTimeMillis();
		
		structures.add(new Structure(libelle+".1"));
		structures.add(new Structure(libelle+".2"));
		structures.add(new Structure(libelle+".3"));
		
		/*for(Structure structure : structures){
			structureService.create(new Structure("TerritoireTest"));
		}*/
	}

	@Test
	public void shouldCreateStructure() throws EntityExistsException, EntityNotFoundException{
		structureService.create(new Structure(libelle));
		assertThat(structureService.retrieveStructureByLibelle(libelle)).isNotNull();
	}

	@Test
	@Rollback(true)
	public void shouldCreateStructureFailedBecauseLibelleExist() throws EntityExistsException{
		Structure structure = new Structure("Territoire1");
		try{
			structureService.create(structure);
			structureService.create(structure);
			fail();
		}catch(Exception e){
			assertThat(e).isInstanceOf(EntityExistsException.class);
		}
	}
	
	



}

