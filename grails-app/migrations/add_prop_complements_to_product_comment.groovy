databaseChangeLog = {

	changeSet(author: "RicardoTIM (generated)", id: "1439500986536-1") {
		addColumn(tableName: "product_comment") {
			column(name: "complements", type: "longtext")
		}
	}
}
