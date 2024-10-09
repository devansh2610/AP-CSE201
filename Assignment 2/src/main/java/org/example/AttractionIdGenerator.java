package org.example;

class AttractionIdGenerator {
    static int attractionidcount = 0;

    static int generateUniqueId() {
        return ++attractionidcount;
    }
}
