package BasicTests;

import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;
import org.testng.annotations.Test;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

public class CycleCheck {
  JavaClasses importedClasses = new ClassFileImporter().importPackages("demo");

	@Test
	public void cycle_check() throws Exception{
		
	 ArchRule cycle_check=
		slices()
		.matching("..demo..(*)..")
		.should()
		.beFreeOfCycles();
		cycle_check.check(importedClasses);
	 
		}

}
