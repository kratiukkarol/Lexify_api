package com.kklabs.lexify.api.repository

import com.kklabs.lexify.api.model.Word
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface WordsRepository : JpaRepository<Word, String>