/* Write your T-SQL query statement below */
with cte_tiv_2015 as (
    select 
        tiv_2015,
        count(*) as total
    from Insurance
    group by tiv_2015
),cte_location as (
    select
        lat,
        lon,
        count(*) as total
    from Insurance
    group by lat, lon
)
select
    round(sum(a.tiv_2016), 2) as tiv_2016
from Insurance a
join cte_tiv_2015 b on a.tiv_2015 = b.tiv_2015
join cte_location c on a.lat = c.lat and a.lon = c.lon
where b.total > 1 and c.total = 1