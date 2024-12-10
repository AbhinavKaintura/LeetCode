from collections import deque
class Solution:
    def parseBoolExpr(self, expression: str) -> bool:
        
        st = deque()
        for ch in expression:

            if ch == ')':
                values = []
                while st[-1] != '(':
                    values.append(st.pop())
                st.pop()
                op = st.pop()
                result = self.evaluate_subexp(op, values)
                st.append(result)
            elif ch != ',':
                st.append(ch)
        
        return st[-1] == "t"
    
    def evaluate_subexp(self, op, values):
        
        if op == '!':
            return "f" if values[0] == "t" else "t"
        
        if op == '&':
            for value in values:
                if value == "f":
                    return "f"
            return "t"
        
        if op == '|':
            for value in values:
                if value == "t":
                    return "t"
            return "f"
        
        return "f"
    
print(Solution().parseBoolExpr("&(|(f))"))