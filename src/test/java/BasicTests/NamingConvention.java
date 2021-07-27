package BasicTests;

import org.testng.annotations.Test;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class NamingConvention {
	JavaClasses importedClasses = new ClassFileImporter().importPackages("demo");

  @Test
  public void controllers_should_be_suffixed() {
		 ArchRule controllers_should_be_suffixed=
				classes()
				.that()
				.resideInAPackage("..controller..")
				.should()
			
				.haveSimpleNameEndingWith("Controller");
		 		
		 controllers_should_be_suffixed.check(importedClasses);
		}
  @Test
  public void service_should_be_infix_with_service_word() {
	  ArchRule service_should_be_infix=
				classes()
				.that()
				.resideInAPackage("..service..")
				.should()
				
				.haveSimpleNameContaining("Service");

	  service_should_be_infix.check(importedClasses);
		}
  
  @Test
  public void interfaces_with_repository_should_be_in_a_repository_package() {
	  ArchRule interfaces_with_repository_word_should_be_in_a_repository_package=
				
				classes()
				.that()
				.areInterfaces()
				.and()
				.haveSimpleNameContaining("Repository")
				.should()
				
				.resideInAPackage("..repository..");

	  		interfaces_with_repository_word_should_be_in_a_repository_package.check(importedClasses);
		}
}
