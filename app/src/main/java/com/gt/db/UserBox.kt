package com.gt.db

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class UserBox {

    @Id
    var id: Long = 0
    var usrId: String = ""

}