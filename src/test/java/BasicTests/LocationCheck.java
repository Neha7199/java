package BasicTests;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import javax.persistence.Entity;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class LocationCheck {
	JavaClasses importedClasses = new ClassFileImporter().importPackages("demo");

  @Test
  public void classes_annoated_with_entity_annotation_should_resides_in_entity_package() {

		ArchRule cycle_check=
				classes()
				.that()
				.areAnnotatedWith(Entity.class)
				.should()
				.resideInAPackage("..entity..");
		
		cycle_check.check(importedClasses);
}
  @Test
  public void classes_annoated_with_controller_annotation_should_resides_in_controller_package() {

		ArchRule cycle_check=
				classes()
				.that()
				.areAnnotatedWith(Controller.class)
				.or()
				.areAnnotatedWith(RestController.class)
				.should()
				.resideInAPackage("..controller..");
		
		
	cycle_check.check(importedClasses);;
}
  @Test
  public void classes_annoated_with_service_annotation_should_resides_in_service_package() {

		ArchRule cycle_check=
				classes()
				.that()
				.areAnnotatedWith(Service.class)
				.should()
				.resideInAPackage("..service..");
		
		cycle_check.check(importedClasses);
		
}
  @Test
	public void interfaces_should_not_placed_in_entity_package() {
	ArchRule interfaces_should_not_placed_in_entity_package=
			classes()
			.that()
			.resideInAPackage("..entity")
			.should()
			.notBeInterfaces();
			interfaces_should_not_placed_in_entity_package.check(importedClasses);
	}
  
 
}
