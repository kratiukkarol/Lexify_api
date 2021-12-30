package com.kklabs.lexify.api.controller

import com.kklabs.lexify.api.model.Word
import com.kklabs.lexify.api.repository.WordsRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/lexify/api/")
class WordsController(val wordsRepository: WordsRepository) {

    @GetMapping("/words")
    fun getAllWords(): List<Word> = wordsRepository.findAll()

    @PostMapping("/save")
    fun saveWord(@Valid @RequestBody word: Word): Word = wordsRepository.save(word)

    @GetMapping("/words/{id}")
    fun getWordById(@PathVariable(value = "id") wordId: String): ResponseEntity<Word> {
        return wordsRepository.findById(wordId).map { word ->
            ResponseEntity.ok(word)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/words/{id}")
    fun updateWordById(
        @PathVariable(value = "id") wordId: String,
        @Valid @RequestBody newWord: Word
    ): ResponseEntity<Word> {
        return wordsRepository.findById(wordId).map { existingWord ->
            val updatedWord: Word = existingWord
                .copy(
                    partOfSpeech = newWord.partOfSpeech,
                    level = newWord.level,
                    nextTranslationTime = newWord.nextTranslationTime,
                    toRepeat = newWord.toRepeat,
                    memorized = newWord.memorized,
                    polish = newWord.polish,
                    definition = newWord.definition,
                    example = newWord.example,
                    pluralForm = newWord.pluralForm,
                    simplePastForm = newWord.simplePastForm,
                    pastParticipleForm = newWord.pastParticipleForm,
                    gerundForm = newWord.gerundForm,
                    comparativeForm = newWord.comparativeForm,
                    superlativeForm = newWord.superlativeForm
                )
            ResponseEntity.ok().body(wordsRepository.save(updatedWord))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/words/{id}")
    fun deleteWordById(@PathVariable(value = "id") wordId: String): ResponseEntity<Void> {
        return wordsRepository.findById(wordId).map { word ->
            wordsRepository.delete(word)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }
}