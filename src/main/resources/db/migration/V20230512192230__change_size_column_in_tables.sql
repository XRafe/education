ALTER TABLE if exists education.stage
    ALTER COLUMN "data" TYPE varchar USING "data"::varchar;

ALTER TABLE if exists education.stage_result
    ALTER COLUMN answer TYPE varchar USING answer::varchar;
