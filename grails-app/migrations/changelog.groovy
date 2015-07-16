databaseChangeLog = {

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-1") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-1") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "activity") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "activityPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "activity", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "place", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-2") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-2") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "address") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "addressPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "county", type: "varchar(100)")

			column(name: "neighborhood", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "state", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "street", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "town", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "zipcode", type: "varchar(5)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-3") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-3") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "audio") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "audioPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-4") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-4") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "business_activity") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "business_actiPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-5") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-5") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "buyer") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "buyerPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-6") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-6") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "collaborator") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "collaboratorPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "middle_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "varchar(10000)")

			column(name: "position", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-7") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-7") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "collaborator_email") {
			column(name: "collaborator_emails_id", type: "bigint")

			column(name: "email_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-8") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-8") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "collaborator_telephone") {
			column(name: "collaborator_telephones_id", type: "bigint")

			column(name: "telephone_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-9") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-9") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "company") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "companyPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "bigint")

			column(name: "assigned_id", type: "bigint")

			column(name: "corporate_press_path", type: "varchar(255)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "datos_fiscales_id", type: "bigint")

			column(name: "description", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "logo_path", type: "varchar(255)")

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "longtext")

			column(name: "social_id", type: "bigint")

			column(name: "tags", type: "longtext")

			column(name: "type_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "web", type: "varchar(100)")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-10") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-10") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "company_comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "company_commePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "collaborators", type: "longtext")

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "datos_fiscales", type: "longtext")

			column(name: "description", type: "longtext")

			column(name: "events", type: "longtext")

			column(name: "general", type: "longtext")

			column(name: "notes", type: "longtext")

			column(name: "refs", type: "longtext")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-11") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-11") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "company_validation") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "company_validPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "message", type: "varchar(10000)")

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-12") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-12") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "complement") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "complementPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "price", type: "decimal(19,2)") {
				constraints(nullable: "false")
			}

			column(name: "product_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-13") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-13") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "contact") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "contactPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "bigint")

			column(name: "biography", type: "varchar(10000)")

			column(name: "birth_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "entry_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "mother_last_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "nationality", type: "varchar(50)")

			column(name: "other", type: "varchar(50)")

			column(name: "photo_path", type: "varchar(255)")

			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "social_id", type: "bigint")

			column(name: "style", type: "varchar(10000)")

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-14") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-14") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "contact_email") {
			column(name: "contact_emails_id", type: "bigint")

			column(name: "email_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-15") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-15") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "datos_fiscales") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "datos_fiscalePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "bigint")

			column(name: "persona_juridica", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "razon_social", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "rfc", type: "varchar(50)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-16") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-16") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "email") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "emailPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "address", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-17") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-17") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "event") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "eventPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "activity", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "place", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-18") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-18") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "facilitator") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "facilitatorPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-19") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-19") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "genre") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "genrePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-20") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-20") {
		createTable(tableName: "localization") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "localizationPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "code", type: "varchar(250)") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "loc", type: "varchar(4)") {
				constraints(nullable: "false")
			}

			column(name: "relevance", type: "tinyint") {
				constraints(nullable: "false")
			}

			column(name: "text", type: "varchar(2000)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-21") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "musician") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "musicianPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "active", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "address_id", type: "bigint")

			column(name: "assigned_id", type: "bigint")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "datos_fiscales_id", type: "bigint")

			column(name: "formed", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "genre_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "has_manager", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "history", type: "varchar(10000)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "logo_path", type: "varchar(36)")

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "varchar(10000)")

			column(name: "social_id", type: "bigint")

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "web", type: "varchar(100)")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-21") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-22") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "musician_comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "musician_commPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "activities", type: "longtext")

			column(name: "contacts", type: "longtext")

			column(name: "datos_fiscales", type: "longtext")

			column(name: "general", type: "longtext")

			column(name: "history", type: "longtext")

			column(name: "medias", type: "longtext")

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "longtext")

			column(name: "suggestions", type: "longtext")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-22") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-23") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "musician_role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "musician_rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(50)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-23") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-24") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "musician_validation") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "musician_valiPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "message", type: "varchar(10000)")

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-24") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-25") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "photo") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "photoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "path", type: "varchar(36)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-25") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-26") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "product") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "productPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "benefits", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "campaign", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "campaign_description", type: "longtext")

			column(name: "clients", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "competence", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "customer_model", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "discount_model", type: "longtext")

			column(name: "distribution_model", type: "longtext")

			column(name: "event", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "event_description", type: "longtext")

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "notes", type: "longtext")

			column(name: "other", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "other_description", type: "longtext")

			column(name: "post_sale_model", type: "longtext")

			column(name: "product_comment_id", type: "bigint")

			column(name: "sales_model", type: "longtext")

			column(name: "target", type: "longtext") {
				constraints(nullable: "false")
			}

			column(name: "telephone", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "telephone_description", type: "longtext")

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "video_link", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "web", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "web_description", type: "longtext")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-26") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-27") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "product_comment") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "product_commePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "benefits", type: "longtext")

			column(name: "competence", type: "longtext")

			column(name: "customer_model", type: "longtext")

			column(name: "description", type: "longtext")

			column(name: "discount_model", type: "longtext")

			column(name: "distribution_model", type: "longtext")

			column(name: "general", type: "longtext")

			column(name: "notes", type: "longtext")

			column(name: "target", type: "longtext")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-27") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-28") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "profile") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "profilePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "middle_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)")

			column(name: "photo_path", type: "varchar(255)")

			column(name: "resume_path", type: "varchar(255)")

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-28") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-29") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "reference") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "referencePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "company_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "contact_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)")

			column(name: "type_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-29") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-30") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "registration_code") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "registration_PK")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "timestamp", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "token", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-30") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-31") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-31") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-32") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "social") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "socialPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "facebook", type: "varchar(100)")

			column(name: "google_plus", type: "varchar(100)")

			column(name: "instagram", type: "varchar(100)")

			column(name: "linkedin", type: "varchar(100)")

			column(name: "other", type: "varchar(100)")

			column(name: "twitter", type: "varchar(100)")

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "youtube", type: "varchar(100)")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-32") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-33") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "suggestion") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "suggestionPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "contact_name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(200)") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-33") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-34") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "tag_links") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tag_linksPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "tag_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "tag_ref", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-34") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-35") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "tags") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tagsPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-35") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-36") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "telephone") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "telephonePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "contact_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "phone", type: "varchar(10)") {
				constraints(nullable: "false")
			}

			column(name: "type", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-36") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-37") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "profile_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-37") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-38") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "user_email") {
			column(name: "user_emails_id", type: "bigint")

			column(name: "email_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-38") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-39") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-39") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-40") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "user_telephone") {
			column(name: "user_telephones_id", type: "bigint")

			column(name: "telephone_id", type: "bigint")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-40") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-41") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "validation_message") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "validation_mePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "message", type: "varchar(10000)") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-41") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-42") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createTable(tableName: "video") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "videoPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "musician_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-42") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-95") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-43") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-96") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_s4saebhlisgfv458ks5lxwfk5", tableName: "activity") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-96") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-97") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_oo0qi54r09mffw0s7tdls4vnn", tableName: "audio") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-97") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-98") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_apavm25dnckvwx0igxixayr5o", tableName: "collaborator") {
			column(name: "company_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-98") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-99") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_auky8gkjodx3yb2t9l23h8bb5", tableName: "collaborator_email") {
			column(name: "email_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-99") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-100") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_h7js0t8kueou4pxujy46ccs28", tableName: "collaborator_email") {
			column(name: "collaborator_emails_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-100") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-101") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_4riy8s0t2j3acc4dx29188m5g", tableName: "collaborator_telephone") {
			column(name: "telephone_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-101") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-102") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_jtq3b6cm067b8cbx0949bn1nf", tableName: "collaborator_telephone") {
			column(name: "collaborator_telephones_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-102") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-103") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_29e7kigcj3o1n1hr7xdye8rma", tableName: "company") {
			column(name: "social_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-103") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-104") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_6fame86hdykgo8wlb2nfkleju", tableName: "company") {
			column(name: "type_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-104") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-105") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_g82ixrst2tc542u5s214ggpdf", tableName: "company") {
			column(name: "user_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-105") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-106") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_h2rewspdf9bnwpbt1nauwiaww", tableName: "company") {
			column(name: "address_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-106") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-107") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_px7wpskggmaqyv5hugyhmlrh", tableName: "company") {
			column(name: "assigned_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-107") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-108") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_qs2etwu504m9iiux8g6bxnbsr", tableName: "company") {
			column(name: "datos_fiscales_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-108") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-109") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_27svoac7udkgucob8x42cgk8n", tableName: "company_comment") {
			column(name: "company_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-109") {
		createIndex(indexName: "company_id_uniq_1437061624322", tableName: "company_comment", unique: "true") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-110") {
		createIndex(indexName: "company_id_uniq_1437061845182", tableName: "company_comment", unique: "true") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
			column(name: "company_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-110") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-111") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_a8s8459b3eicx6pllc4de0e3m", tableName: "company_validation") {
			column(name: "company_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-111") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-112") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_leia2q4jssj66evlfoi9u1sey", tableName: "company_validation") {
			column(name: "user_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-112") {
		createIndex(indexName: "company_id_uniq_1437061624326", tableName: "company_validation", unique: "true") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-113") {
		createIndex(indexName: "company_id_uniq_1437061845183", tableName: "company_validation", unique: "true") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
			column(name: "company_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-113") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-114") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_41xvdqhy8jitwhyulfoox9aei", tableName: "complement") {
			column(name: "product_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-114") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-115") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_8rcuhh4i0uum1tryi4tkaomoq", tableName: "contact") {
			column(name: "role_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-115") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-116") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_hdhcc7238a2lwr4yjw78qvlof", tableName: "contact") {
			column(name: "address_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-116") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-117") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_iu66rh5jr753g1snpeckccpnd", tableName: "contact") {
			column(name: "social_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-117") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-118") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_qce5hi0s8xngx6abn6t5qqdh1", tableName: "contact") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-118") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-119") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_cympokuqia82xrakkgmo81je", tableName: "contact_email") {
			column(name: "contact_emails_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-119") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-120") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_iarmsp0o5pw64ns9nitrnpyc1", tableName: "contact_email") {
			column(name: "email_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-120") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-121") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_pjuse4nbsyy9iapot4t48ji9c", tableName: "datos_fiscales") {
			column(name: "address_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-121") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-122") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_gpf8dt5coprxfjt3ivpoqwvd4", tableName: "event") {
			column(name: "company_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-122") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-123") {
		createIndex(indexName: "localizations_idx", tableName: "localization") {
			column(name: "code")
		}
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-124") {
		createIndex(indexName: "unique_loc", tableName: "localization", unique: "true") {
			column(name: "code")

			column(name: "loc")
		}
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-125") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_c6m47md1l2deho73aq1vmk2hc", tableName: "musician") {
			column(name: "datos_fiscales_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-123") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-126") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_clcuv4femydlirbpxllqabp47", tableName: "musician") {
			column(name: "user_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-124") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-127") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_ls5crp81sdo77jp2aoh4jfboo", tableName: "musician") {
			column(name: "genre_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-125") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-128") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_nxah8pk0uolulpyldcbbn61j0", tableName: "musician") {
			column(name: "social_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-126") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-129") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_sykchqeqn5e6rfa8shuan9tm8", tableName: "musician") {
			column(name: "assigned_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-127") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-130") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_tnq8ruyw7fyhilr7l9m58b3iu", tableName: "musician") {
			column(name: "address_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-128") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-131") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_o0a4t8njpy2begfa4hece9wn3", tableName: "musician_comment") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-129") {
		createIndex(indexName: "musician_id_uniq_1437061624340", tableName: "musician_comment", unique: "true") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-132") {
		createIndex(indexName: "musician_id_uniq_1437061845194", tableName: "musician_comment", unique: "true") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-130") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-133") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_8fusjimaf8xewyyosua1cwn09", tableName: "musician_validation") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-131") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-134") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_looghw1dl328qony0vspjkxxl", tableName: "musician_validation") {
			column(name: "user_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-132") {
		createIndex(indexName: "musician_id_uniq_1437061624341", tableName: "musician_validation", unique: "true") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-135") {
		createIndex(indexName: "musician_id_uniq_1437061845195", tableName: "musician_validation", unique: "true") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-133") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-136") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_f3hnt0xjvbddm6kdw9nlgxcqo", tableName: "photo") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-134") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-137") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_45g3a4rexapplpirj3jor716p", tableName: "product") {
			column(name: "company_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-135") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-138") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_aqyrrujh6k7xk02bupabc98vq", tableName: "product") {
			column(name: "product_comment_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-136") {
		createIndex(indexName: "email_uniq_1437061624346", tableName: "profile", unique: "true") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-139") {
		createIndex(indexName: "email_uniq_1437061845201", tableName: "profile", unique: "true") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
			column(name: "email")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-137") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-140") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_7ismr0wetsn4sdv1n0r55ip4a", tableName: "reference") {
			column(name: "type_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-138") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-141") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_o61ou11akolomal5ne95bpsh7", tableName: "reference") {
			column(name: "company_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-139") {
		createIndex(indexName: "authority_uniq_1437061624350", tableName: "role", unique: "true") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-142") {
		createIndex(indexName: "authority_uniq_1437061845204", tableName: "role", unique: "true") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
			column(name: "authority")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-140") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-143") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_9kbb6ggcjy9kusn382c6dauwk", tableName: "suggestion") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-141") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-144") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_lmil1jg72pjc8ei5p6kk5g9un", tableName: "tag_links") {
			column(name: "tag_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-142") {
		createIndex(indexName: "name_uniq_1437061624354", tableName: "tags", unique: "true") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-145") {
		createIndex(indexName: "name_uniq_1437061845207", tableName: "tags", unique: "true") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
			column(name: "name")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-143") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-146") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_cgavsyoc3ot92fi9nu8mgheis", tableName: "telephone") {
			column(name: "contact_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-144") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-147") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_1mcjtpxmwom9h9bf2q0k412e0", tableName: "user") {
			column(name: "profile_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-145") {
		createIndex(indexName: "username_uniq_1437061624357", tableName: "user", unique: "true") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-148") {
		createIndex(indexName: "username_uniq_1437061845209", tableName: "user", unique: "true") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
			column(name: "username")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-146") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-149") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_c6icvhh11873ab6ys4t6lmj9l", tableName: "user_email") {
			column(name: "user_emails_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-147") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-150") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_ga2lakvpd1h851gbjmv45ln0g", tableName: "user_email") {
			column(name: "email_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-148") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-151") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_apcc8lxk2xnug8377fatvbn04", tableName: "user_role") {
			column(name: "user_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-149") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-152") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_it77eq964jhfqtu54081ebtio", tableName: "user_role") {
			column(name: "role_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-150") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-153") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_kayqg2jxrv0cbqvflyjhiy41g", tableName: "user_telephone") {
			column(name: "telephone_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-151") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-154") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_o9ffnbh6gmgiqswgr7tnmd33u", tableName: "user_telephone") {
			column(name: "user_telephones_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-152") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-155") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_3ugn6wij9gp6ryqbt38qt61jb", tableName: "validation_message") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-153") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-156") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_al181veet6d6uh3x3fpx7y5y7", tableName: "validation_message") {
			column(name: "user_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-154") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-157") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		createIndex(indexName: "FK_s0eh4ylgywtxpqxhjk73yf0e6", tableName: "video") {
			column(name: "musician_id")
		}
	}

<<<<<<< HEAD
	changeSet(author: "josdem (generated)", id: "1437061624433-43") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "activity", constraintName: "FK_s4saebhlisgfv458ks5lxwfk5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-44") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "audio", constraintName: "FK_oo0qi54r09mffw0s7tdls4vnn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-45") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "collaborator", constraintName: "FK_apavm25dnckvwx0igxixayr5o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-46") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_emails_id", baseTableName: "collaborator_email", constraintName: "FK_h7js0t8kueou4pxujy46ccs28", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-47") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "collaborator_email", constraintName: "FK_auky8gkjodx3yb2t9l23h8bb5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-48") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_telephones_id", baseTableName: "collaborator_telephone", constraintName: "FK_jtq3b6cm067b8cbx0949bn1nf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-49") {
		addForeignKeyConstraint(baseColumnNames: "telephone_id", baseTableName: "collaborator_telephone", constraintName: "FK_4riy8s0t2j3acc4dx29188m5g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telephone", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-50") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "company", constraintName: "FK_h2rewspdf9bnwpbt1nauwiaww", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-51") {
		addForeignKeyConstraint(baseColumnNames: "assigned_id", baseTableName: "company", constraintName: "FK_px7wpskggmaqyv5hugyhmlrh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-52") {
		addForeignKeyConstraint(baseColumnNames: "datos_fiscales_id", baseTableName: "company", constraintName: "FK_qs2etwu504m9iiux8g6bxnbsr", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "datos_fiscales", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-53") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "company", constraintName: "FK_29e7kigcj3o1n1hr7xdye8rma", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-54") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "company", constraintName: "FK_6fame86hdykgo8wlb2nfkleju", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "business_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-55") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "company", constraintName: "FK_g82ixrst2tc542u5s214ggpdf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-56") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "company_comment", constraintName: "FK_27svoac7udkgucob8x42cgk8n", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-57") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "company_validation", constraintName: "FK_a8s8459b3eicx6pllc4de0e3m", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-58") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "company_validation", constraintName: "FK_leia2q4jssj66evlfoi9u1sey", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-59") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "complement", constraintName: "FK_41xvdqhy8jitwhyulfoox9aei", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-60") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "contact", constraintName: "FK_hdhcc7238a2lwr4yjw78qvlof", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-61") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "contact", constraintName: "FK_qce5hi0s8xngx6abn6t5qqdh1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-62") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "contact", constraintName: "FK_8rcuhh4i0uum1tryi4tkaomoq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician_role", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-63") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "contact", constraintName: "FK_iu66rh5jr753g1snpeckccpnd", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-64") {
		addForeignKeyConstraint(baseColumnNames: "contact_emails_id", baseTableName: "contact_email", constraintName: "FK_cympokuqia82xrakkgmo81je", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-65") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "contact_email", constraintName: "FK_iarmsp0o5pw64ns9nitrnpyc1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-66") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "datos_fiscales", constraintName: "FK_pjuse4nbsyy9iapot4t48ji9c", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-67") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "event", constraintName: "FK_gpf8dt5coprxfjt3ivpoqwvd4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-68") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "musician", constraintName: "FK_tnq8ruyw7fyhilr7l9m58b3iu", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-69") {
		addForeignKeyConstraint(baseColumnNames: "assigned_id", baseTableName: "musician", constraintName: "FK_sykchqeqn5e6rfa8shuan9tm8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-70") {
		addForeignKeyConstraint(baseColumnNames: "datos_fiscales_id", baseTableName: "musician", constraintName: "FK_c6m47md1l2deho73aq1vmk2hc", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "datos_fiscales", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-71") {
		addForeignKeyConstraint(baseColumnNames: "genre_id", baseTableName: "musician", constraintName: "FK_ls5crp81sdo77jp2aoh4jfboo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "genre", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-72") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "musician", constraintName: "FK_nxah8pk0uolulpyldcbbn61j0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-73") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "musician", constraintName: "FK_clcuv4femydlirbpxllqabp47", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-74") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "musician_comment", constraintName: "FK_o0a4t8njpy2begfa4hece9wn3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-75") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "musician_validation", constraintName: "FK_8fusjimaf8xewyyosua1cwn09", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-76") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "musician_validation", constraintName: "FK_looghw1dl328qony0vspjkxxl", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-77") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "photo", constraintName: "FK_f3hnt0xjvbddm6kdw9nlgxcqo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-78") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "product", constraintName: "FK_45g3a4rexapplpirj3jor716p", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-79") {
		addForeignKeyConstraint(baseColumnNames: "product_comment_id", baseTableName: "product", constraintName: "FK_aqyrrujh6k7xk02bupabc98vq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product_comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-80") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "reference", constraintName: "FK_o61ou11akolomal5ne95bpsh7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-81") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "reference", constraintName: "FK_7ismr0wetsn4sdv1n0r55ip4a", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "business_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-82") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "suggestion", constraintName: "FK_9kbb6ggcjy9kusn382c6dauwk", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-83") {
		addForeignKeyConstraint(baseColumnNames: "tag_id", baseTableName: "tag_links", constraintName: "FK_lmil1jg72pjc8ei5p6kk5g9un", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tags", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-84") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "telephone", constraintName: "FK_cgavsyoc3ot92fi9nu8mgheis", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-85") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "user", constraintName: "FK_1mcjtpxmwom9h9bf2q0k412e0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-86") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "user_email", constraintName: "FK_ga2lakvpd1h851gbjmv45ln0g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-87") {
		addForeignKeyConstraint(baseColumnNames: "user_emails_id", baseTableName: "user_email", constraintName: "FK_c6icvhh11873ab6ys4t6lmj9l", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-88") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK_it77eq964jhfqtu54081ebtio", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-89") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK_apcc8lxk2xnug8377fatvbn04", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-90") {
		addForeignKeyConstraint(baseColumnNames: "telephone_id", baseTableName: "user_telephone", constraintName: "FK_kayqg2jxrv0cbqvflyjhiy41g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telephone", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-91") {
		addForeignKeyConstraint(baseColumnNames: "user_telephones_id", baseTableName: "user_telephone", constraintName: "FK_o9ffnbh6gmgiqswgr7tnmd33u", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-92") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "validation_message", constraintName: "FK_3ugn6wij9gp6ryqbt38qt61jb", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-93") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "validation_message", constraintName: "FK_al181veet6d6uh3x3fpx7y5y7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "josdem (generated)", id: "1437061624433-94") {
=======
	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-44") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "activity", constraintName: "FK_s4saebhlisgfv458ks5lxwfk5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-45") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "audio", constraintName: "FK_oo0qi54r09mffw0s7tdls4vnn", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-46") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "collaborator", constraintName: "FK_apavm25dnckvwx0igxixayr5o", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-47") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_emails_id", baseTableName: "collaborator_email", constraintName: "FK_h7js0t8kueou4pxujy46ccs28", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-48") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "collaborator_email", constraintName: "FK_auky8gkjodx3yb2t9l23h8bb5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-49") {
		addForeignKeyConstraint(baseColumnNames: "collaborator_telephones_id", baseTableName: "collaborator_telephone", constraintName: "FK_jtq3b6cm067b8cbx0949bn1nf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "collaborator", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-50") {
		addForeignKeyConstraint(baseColumnNames: "telephone_id", baseTableName: "collaborator_telephone", constraintName: "FK_4riy8s0t2j3acc4dx29188m5g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telephone", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-51") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "company", constraintName: "FK_h2rewspdf9bnwpbt1nauwiaww", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-52") {
		addForeignKeyConstraint(baseColumnNames: "assigned_id", baseTableName: "company", constraintName: "FK_px7wpskggmaqyv5hugyhmlrh", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-53") {
		addForeignKeyConstraint(baseColumnNames: "datos_fiscales_id", baseTableName: "company", constraintName: "FK_qs2etwu504m9iiux8g6bxnbsr", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "datos_fiscales", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-54") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "company", constraintName: "FK_29e7kigcj3o1n1hr7xdye8rma", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-55") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "company", constraintName: "FK_6fame86hdykgo8wlb2nfkleju", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "business_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-56") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "company", constraintName: "FK_g82ixrst2tc542u5s214ggpdf", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-57") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "company_comment", constraintName: "FK_27svoac7udkgucob8x42cgk8n", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-58") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "company_validation", constraintName: "FK_a8s8459b3eicx6pllc4de0e3m", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-59") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "company_validation", constraintName: "FK_leia2q4jssj66evlfoi9u1sey", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-60") {
		addForeignKeyConstraint(baseColumnNames: "product_id", baseTableName: "complement", constraintName: "FK_41xvdqhy8jitwhyulfoox9aei", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-61") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "contact", constraintName: "FK_hdhcc7238a2lwr4yjw78qvlof", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-62") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "contact", constraintName: "FK_qce5hi0s8xngx6abn6t5qqdh1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-63") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "contact", constraintName: "FK_8rcuhh4i0uum1tryi4tkaomoq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician_role", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-64") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "contact", constraintName: "FK_iu66rh5jr753g1snpeckccpnd", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-65") {
		addForeignKeyConstraint(baseColumnNames: "contact_emails_id", baseTableName: "contact_email", constraintName: "FK_cympokuqia82xrakkgmo81je", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-66") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "contact_email", constraintName: "FK_iarmsp0o5pw64ns9nitrnpyc1", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-67") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "datos_fiscales", constraintName: "FK_pjuse4nbsyy9iapot4t48ji9c", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-68") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "event", constraintName: "FK_gpf8dt5coprxfjt3ivpoqwvd4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-69") {
		addForeignKeyConstraint(baseColumnNames: "address_id", baseTableName: "musician", constraintName: "FK_tnq8ruyw7fyhilr7l9m58b3iu", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "address", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-70") {
		addForeignKeyConstraint(baseColumnNames: "assigned_id", baseTableName: "musician", constraintName: "FK_sykchqeqn5e6rfa8shuan9tm8", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-71") {
		addForeignKeyConstraint(baseColumnNames: "datos_fiscales_id", baseTableName: "musician", constraintName: "FK_c6m47md1l2deho73aq1vmk2hc", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "datos_fiscales", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-72") {
		addForeignKeyConstraint(baseColumnNames: "genre_id", baseTableName: "musician", constraintName: "FK_ls5crp81sdo77jp2aoh4jfboo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "genre", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-73") {
		addForeignKeyConstraint(baseColumnNames: "social_id", baseTableName: "musician", constraintName: "FK_nxah8pk0uolulpyldcbbn61j0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "social", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-74") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "musician", constraintName: "FK_clcuv4femydlirbpxllqabp47", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-75") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "musician_comment", constraintName: "FK_o0a4t8njpy2begfa4hece9wn3", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-76") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "musician_validation", constraintName: "FK_8fusjimaf8xewyyosua1cwn09", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-77") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "musician_validation", constraintName: "FK_looghw1dl328qony0vspjkxxl", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-78") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "photo", constraintName: "FK_f3hnt0xjvbddm6kdw9nlgxcqo", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-79") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "product", constraintName: "FK_45g3a4rexapplpirj3jor716p", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-80") {
		addForeignKeyConstraint(baseColumnNames: "product_comment_id", baseTableName: "product", constraintName: "FK_aqyrrujh6k7xk02bupabc98vq", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "product_comment", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-81") {
		addForeignKeyConstraint(baseColumnNames: "company_id", baseTableName: "reference", constraintName: "FK_o61ou11akolomal5ne95bpsh7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "company", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-82") {
		addForeignKeyConstraint(baseColumnNames: "type_id", baseTableName: "reference", constraintName: "FK_7ismr0wetsn4sdv1n0r55ip4a", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "business_activity", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-83") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "suggestion", constraintName: "FK_9kbb6ggcjy9kusn382c6dauwk", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-84") {
		addForeignKeyConstraint(baseColumnNames: "tag_id", baseTableName: "tag_links", constraintName: "FK_lmil1jg72pjc8ei5p6kk5g9un", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tags", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-85") {
		addForeignKeyConstraint(baseColumnNames: "contact_id", baseTableName: "telephone", constraintName: "FK_cgavsyoc3ot92fi9nu8mgheis", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "contact", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-86") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "user", constraintName: "FK_1mcjtpxmwom9h9bf2q0k412e0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-87") {
		addForeignKeyConstraint(baseColumnNames: "email_id", baseTableName: "user_email", constraintName: "FK_ga2lakvpd1h851gbjmv45ln0g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "email", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-88") {
		addForeignKeyConstraint(baseColumnNames: "user_emails_id", baseTableName: "user_email", constraintName: "FK_c6icvhh11873ab6ys4t6lmj9l", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-89") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK_it77eq964jhfqtu54081ebtio", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-90") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK_apcc8lxk2xnug8377fatvbn04", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-91") {
		addForeignKeyConstraint(baseColumnNames: "telephone_id", baseTableName: "user_telephone", constraintName: "FK_kayqg2jxrv0cbqvflyjhiy41g", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "telephone", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-92") {
		addForeignKeyConstraint(baseColumnNames: "user_telephones_id", baseTableName: "user_telephone", constraintName: "FK_o9ffnbh6gmgiqswgr7tnmd33u", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-93") {
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "validation_message", constraintName: "FK_3ugn6wij9gp6ryqbt38qt61jb", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-94") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "validation_message", constraintName: "FK_al181veet6d6uh3x3fpx7y5y7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "RicardoTIM (generated)", id: "1437061845224-95") {
>>>>>>> abfcc234a58c9aeaa1121f323dc6231df702d1e7
		addForeignKeyConstraint(baseColumnNames: "musician_id", baseTableName: "video", constraintName: "FK_s0eh4ylgywtxpqxhjk73yf0e6", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "musician", referencesUniqueColumn: "false")
	}
}
