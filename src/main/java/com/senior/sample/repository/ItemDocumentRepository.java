package com.senior.sample.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.senior.sample.domain.ItemDocument;

public interface ItemDocumentRepository extends ElasticsearchRepository<ItemDocument, String> {
}