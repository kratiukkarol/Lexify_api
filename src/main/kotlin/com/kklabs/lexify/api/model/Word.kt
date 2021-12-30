package com.kklabs.lexify.api.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "words")
data class Word(
    val partOfSpeech: PartOfSpeech,
    val created: Long,
    var level: Int,
    var lastTranslationTime: Long,
    var nextTranslationTime: Long,
    var toRepeat: Boolean,
    var memorized: Boolean,
    val polish: String,
    @Id val english: String,
    var definition: String?,
    var example: String?,
    val pluralForm: String?,
    val simplePastForm: String?,
    val pastParticipleForm: String?,
    val gerundForm: String?,
    val comparativeForm: String?,
    val superlativeForm: String?)

enum class PartOfSpeech {NOUN, VERB, ADJECTIVE, IDIOM, PHRASAL, COLLOQUIALISM, OTHER}
