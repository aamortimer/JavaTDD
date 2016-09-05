/**
 * Created by amortimer on 05/09/2016.
 */

import com.ninja_squad.dbsetup.operation.Operation;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

public class CommonOperations {
    public static final Operation DELETE_ALL = deleteAllFrom("Employees", "Address");
    public static final Operation INSERT_REFERENCE_DATA = sequenceOf(insertInto("Employees")
            .columns("id", "firstName", "lastName")
            .values(1, "Jon", "Doe")
            .values(2, "Jane", "Doe")
            .build());
}

