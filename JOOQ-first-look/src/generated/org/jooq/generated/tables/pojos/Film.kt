/*
 * This file is generated by jOOQ.
 */
package org.jooq.generated.tables.pojos


import java.io.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime
import java.time.Year

import org.jooq.generated.enums.FilmRating


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
data class Film(
    var filmId: Long? = null,
    var title: String? = null,
    var description: String? = null,
    var releaseYear: Year? = null,
    var languageId: Long? = null,
    var originalLanguageId: Long? = null,
    var rentalDuration: Int? = null,
    var rentalRate: BigDecimal? = null,
    var length: Int? = null,
    var replacementCost: BigDecimal? = null,
    var rating: FilmRating? = null,
    var specialFeatures: String? = null,
    var lastUpdate: LocalDateTime? = null
): Serializable {


    override fun equals(other: Any?): Boolean {
        if (this === other)
            return true
        if (other == null)
            return false
        if (this::class != other::class)
            return false
        val o: Film = other as Film
        if (this.filmId == null) {
            if (o.filmId != null)
                return false
        }
        else if (this.filmId != o.filmId)
            return false
        if (this.title == null) {
            if (o.title != null)
                return false
        }
        else if (this.title != o.title)
            return false
        if (this.description == null) {
            if (o.description != null)
                return false
        }
        else if (this.description != o.description)
            return false
        if (this.releaseYear == null) {
            if (o.releaseYear != null)
                return false
        }
        else if (this.releaseYear != o.releaseYear)
            return false
        if (this.languageId == null) {
            if (o.languageId != null)
                return false
        }
        else if (this.languageId != o.languageId)
            return false
        if (this.originalLanguageId == null) {
            if (o.originalLanguageId != null)
                return false
        }
        else if (this.originalLanguageId != o.originalLanguageId)
            return false
        if (this.rentalDuration == null) {
            if (o.rentalDuration != null)
                return false
        }
        else if (this.rentalDuration != o.rentalDuration)
            return false
        if (this.rentalRate == null) {
            if (o.rentalRate != null)
                return false
        }
        else if (this.rentalRate != o.rentalRate)
            return false
        if (this.length == null) {
            if (o.length != null)
                return false
        }
        else if (this.length != o.length)
            return false
        if (this.replacementCost == null) {
            if (o.replacementCost != null)
                return false
        }
        else if (this.replacementCost != o.replacementCost)
            return false
        if (this.rating == null) {
            if (o.rating != null)
                return false
        }
        else if (this.rating != o.rating)
            return false
        if (this.specialFeatures == null) {
            if (o.specialFeatures != null)
                return false
        }
        else if (this.specialFeatures != o.specialFeatures)
            return false
        if (this.lastUpdate == null) {
            if (o.lastUpdate != null)
                return false
        }
        else if (this.lastUpdate != o.lastUpdate)
            return false
        return true
    }

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + (if (this.filmId == null) 0 else this.filmId.hashCode())
        result = prime * result + (if (this.title == null) 0 else this.title.hashCode())
        result = prime * result + (if (this.description == null) 0 else this.description.hashCode())
        result = prime * result + (if (this.releaseYear == null) 0 else this.releaseYear.hashCode())
        result = prime * result + (if (this.languageId == null) 0 else this.languageId.hashCode())
        result = prime * result + (if (this.originalLanguageId == null) 0 else this.originalLanguageId.hashCode())
        result = prime * result + (if (this.rentalDuration == null) 0 else this.rentalDuration.hashCode())
        result = prime * result + (if (this.rentalRate == null) 0 else this.rentalRate.hashCode())
        result = prime * result + (if (this.length == null) 0 else this.length.hashCode())
        result = prime * result + (if (this.replacementCost == null) 0 else this.replacementCost.hashCode())
        result = prime * result + (if (this.rating == null) 0 else this.rating.hashCode())
        result = prime * result + (if (this.specialFeatures == null) 0 else this.specialFeatures.hashCode())
        result = prime * result + (if (this.lastUpdate == null) 0 else this.lastUpdate.hashCode())
        return result
    }

    override fun toString(): String {
        val sb = StringBuilder("Film (")

        sb.append(filmId)
        sb.append(", ").append(title)
        sb.append(", ").append(description)
        sb.append(", ").append(releaseYear)
        sb.append(", ").append(languageId)
        sb.append(", ").append(originalLanguageId)
        sb.append(", ").append(rentalDuration)
        sb.append(", ").append(rentalRate)
        sb.append(", ").append(length)
        sb.append(", ").append(replacementCost)
        sb.append(", ").append(rating)
        sb.append(", ").append(specialFeatures)
        sb.append(", ").append(lastUpdate)

        sb.append(")")
        return sb.toString()
    }
}