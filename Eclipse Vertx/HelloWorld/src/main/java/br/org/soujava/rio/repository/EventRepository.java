package br.org.soujava.rio.repository;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import br.org.soujava.rio.model.Event;

@Repository
public interface  EventRepository extends EntityRepository<Event, Long>  { }