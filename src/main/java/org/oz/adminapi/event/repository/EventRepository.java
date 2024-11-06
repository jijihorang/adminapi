package org.oz.adminapi.event.repository;

import org.oz.adminapi.event.domain.Event;
import org.oz.adminapi.event.repository.search.EventSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long>, EventSearch {
}
