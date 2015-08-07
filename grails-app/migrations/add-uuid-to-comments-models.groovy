databaseChangeLog = {

	changeSet(author: "RicardoTIM (generated)", id: "1438963413434-1") {
		addColumn(tableName: "company_comment") {
			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "RicardoTIM (generated)", id: "1438963413434-2") {
		addColumn(tableName: "musician_comment") {
			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "RicardoTIM (generated)", id: "1438963413434-3") {
		addColumn(tableName: "product_comment") {
			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}
}
