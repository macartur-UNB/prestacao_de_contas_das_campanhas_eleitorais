<%@ tag language="java" pageEncoding="UTF-8"%>

<%@ attribute name="id" required="true" %>

<input id="${id}" name="${id}" />
<script>
  $("#${id}");
</script>