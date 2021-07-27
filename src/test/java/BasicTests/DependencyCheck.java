package BasicTests;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class DependencyCheck {
	JavaClasses importedClasses = new ClassFileImporter().importPackages("demo");

  @Test
  public void entity_class_should_not_depend_on_anyone() {
		 ArchRule entity_class_should_not_depend_on_anyone=
				noClasses()
				.that()
				.resideInAPackage("..entity..")
				.should()
				
				.dependOnClassesThat()
				
				.resideInAnyPackage("..controller..")
				.orShould()
				.dependOnClassesThat()
				.resideInAPackage("..service..");
		 String a ="Skip Test";
		 if(a.equals("Skip Test")){
		 throw new SkipException("Skipping - This is not ready for testing ");
		 }else
		 entity_class_should_not_depend_on_anyone.check(importedClasses);
		}
}
