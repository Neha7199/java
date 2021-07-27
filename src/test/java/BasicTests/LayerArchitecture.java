package BasicTests;

import org.testng.annotations.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static org.testng.Assert.assertEquals;

public class LayerArchitecture {
	JavaClasses importedClasses = new ClassFileImporter().importPackages("demo");

  @Test
  public void layer_architecture() {
		 ArchRule layer_architecture=
				layeredArchitecture()
				.layer("controller").definedBy("..controller..")
				.layer("service").definedBy("..service..")
				.layer("entity").definedBy("..entity..")
				
				.whereLayer("controller").mayNotBeAccessedByAnyLayer()
				.whereLayer("service").mayOnlyBeAccessedByLayers("controller");
		 		layer_architecture.check(importedClasses);
		}
}
