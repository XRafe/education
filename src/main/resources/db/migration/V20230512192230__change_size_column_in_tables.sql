ALTER TABLE education.stage
    ALTER COLUMN "data" TYPE varchar USING "data"::varchar;

ALTER TABLE education.stage_result
    ALTER COLUMN answer TYPE varchar USING answer::varchar;
