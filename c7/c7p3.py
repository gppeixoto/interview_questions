
class Line:
    epsilon = 1e-6
    def __init__(self, a, b):
        self.slope = a
        self.b = b

    def intercepts(self, y):
        return True if abs(self.slope - y.slope) > Line.epsilon or\
                        abs(self.b - y.b) < Line.epsilon else False


y1 = Line(3.2, 5)
y2 = Line(3.2, 5)
print y1.intercepts(y2)
