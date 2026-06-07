/* Write your T-SQL query statement below */
;with cte_recursive as (
    select 
        a.id as root_id,
        a.id as current_id,
        (a.id + 1) as next_id,
        a.people as people,
        a.visit_date as visit_date
    from Stadium a
    where a.people >= 100
    and not exists (
        select 1 from Stadium b where b.id = a.id - 1
        and b.people >= 100
    )

    union all

    select 
        b.root_id,
        a.id as current_id,
        (a.id + 1) as next_id,
        a.people as people,
        a.visit_date as visit_date
    from Stadium a
    join cte_recursive b on b.next_id = a.id
    where a.people >= 100
),
cte_valid_records as (
    select
        root_id,
        count(*) as total
    from cte_recursive 
    group by root_id
)

select
    a.current_id as id,
    a.visit_date,
    a.people
from cte_recursive a
join cte_valid_records b on a.root_id = b.root_id
where b.total >= 3
order by a.current_id