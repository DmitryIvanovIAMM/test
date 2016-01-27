package models

case class Address(id: Option[Int] = None,
                   address1: String,
                   city: String,
                   state: String,
                   zip: String)