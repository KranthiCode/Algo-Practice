package work;

import javax.annotation.processing.Generated;

class Test {
  int[] arr = { 6, 7, -3, -2, -3, 1, 12 };
  // // 6, 13, 10, 8, 5, 6, 18
  // // 18, 12,,5,8,10,13,12

  // t1 - A , waiting B (1000) - release A
  // t2 - B , waiting A

  // student - id, name, address
  // course - id, name, student_id (fk)

  // - list of all studentes taken more than 2 courses

  // - sid, name

  // select s.id, count(*) as 'count', s.name
  // from course as c
  // left join student as s
  // on c.student_id = s.s_id
  // group by c.student_id
  // having count > 2

  // key-value

}